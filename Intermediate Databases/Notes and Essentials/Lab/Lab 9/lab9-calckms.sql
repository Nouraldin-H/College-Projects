-- 
-- Utility Function created by: Douglas King
-- 
-- Returns 6 decimal place accuracy distance in kms between two points on Earth based on longitude, latitude 
--
-- Uses Oracle sdo_geom package and includes corrections for ellipsoidal earth
-- Usage: select calc_kms(-73.968285, 40.785091, -73.974709, 40.790886) from dual;
--

CREATE OR REPLACE FUNCTION CALC_KMS(long1 in number default 0, lat1 in number default 0, long2 in number default 0, lat2 in number default 0)
RETURN NUMBER
AS
	ret_val	NUMBER(15,6);
BEGIN
	select sdo_geom.sdo_distance(         
  		sdo_geometry(2001, 4326, sdo_point_type(long1, lat1, null), null, null),
  		sdo_geometry(2001, 4326, sdo_point_type(long2, lat2, null), null, null),
  		0.01,
  		'unit=KM'
	) 
	INTO ret_val from dual;
	return ret_val;
END;
/
-- end of file

