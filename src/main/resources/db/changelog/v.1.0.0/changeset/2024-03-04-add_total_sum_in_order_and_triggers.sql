ALTER TABLE orders
    ADD COLUMN total_sum DOUBLE PRECISION;

CREATE OR REPLACE
    FUNCTION calculate_order_total_sum()
    RETURNS TRIGGER AS
$$
BEGIN
    UPDATE orders
    SET total_sum = (SELECT SUM(d.price * dio.count)
                     FROM dishes_in_order dio
                              JOIN dishes d ON d.id_dish = dio.dish_id
                     WHERE dio.order_id = NEW.order_id
                     GROUP BY dio.order_id)
    WHERE id_order = NEW.order_id;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION calculate_order_total_sum_for_delete() RETURNS TRIGGER AS
$$
BEGIN
    UPDATE orders
    SET total_sum = (SELECT COALESCE(SUM(d.price * dio.count), 0)
                     FROM dishes_in_order dio
                              JOIN dishes d ON d.id_dish = dio.dish_id
                     WHERE dio.order_id = OLD.order_id
                     GROUP BY dio.order_id)
    WHERE id_order = OLD.order_id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_order_total_sum_after_insert_or_update
    AFTER INSERT OR UPDATE
    ON dishes_in_order
    FOR EACH ROW
EXECUTE FUNCTION calculate_order_total_sum();

CREATE TRIGGER update_order_total_sum_after_delete
    AFTER DELETE
    ON dishes_in_order
    FOR EACH ROW
EXECUTE FUNCTION calculate_order_total_sum_for_delete();