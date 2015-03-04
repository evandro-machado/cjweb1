CREATE TABLE customer
(
  customerid integer NOT NULL DEFAULT nextval('usuario_idcliente_seq'::regclass),
  customername character varying(50),
  customerpassword character varying(32),
  customerlogi character varying(50),
  CONSTRAINT pkidcliente PRIMARY KEY (customerid)
)