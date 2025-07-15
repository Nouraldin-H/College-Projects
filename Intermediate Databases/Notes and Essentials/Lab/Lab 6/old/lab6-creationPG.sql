CREATE OR REPLACE FUNCTION validate_postal_code() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
        DECLARE

        BEGIN
          IF NEW.postal_code !~ '^\d{5}$' THEN
            RAISE EXCEPTION 'Debug--> postal_code regex check %, %, %', NEW.postal_code !~* '^\d{5}$', TG_OP, NEW.postal_code;
          END IF;
          RETURN NEW;
        END;
      $$;

DROP TRIGGER IF EXISTS address_postal_code_trigger on my_table;
 
CREATE TRIGGER address_postal_code_trigger BEFORE INSERT ON address 
  FOR EACH ROW EXECUTE PROCEDURE validate_postal_code();