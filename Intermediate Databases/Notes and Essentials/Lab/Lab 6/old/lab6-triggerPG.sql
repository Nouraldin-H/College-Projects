CREATE OR REPLACE FUNCTION validate_postal_code() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
        DECLARE

        BEGIN
		  IF NEW.postalcode !~ '^[ABCEGHJKLMNPRSTVXYZ]\d[ABCEGHJKLMNPRSTVWXYZ]\d[ABCEGHJKLMNPRSTVWXYZ]\d' THEN
		    RAISE EXCEPTION 'The postal code (%) must be of the form A1A1A1.', NEW.postalcode;
          END IF;
          RETURN NEW;
        END;
      $$;

DROP TRIGGER IF EXISTS address_postal_code_trigger on my_table;
 
CREATE TRIGGER address_postal_code_trigger BEFORE INSERT ON address 
  FOR EACH ROW EXECUTE PROCEDURE validate_postal_code();