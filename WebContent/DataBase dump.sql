--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.0
-- Dumped by pg_dump version 9.4.0
-- Started on 2015-03-12 09:47:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE cjweb1;
--
-- TOC entry 1999 (class 1262 OID 16832)
-- Name: cjweb1; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE cjweb1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE cjweb1 OWNER TO postgres;

\connect cjweb1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2000 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 174 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2002 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16838)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE customer (
    customerid integer NOT NULL,
    customername character varying(50),
    customerpassword character varying(32),
    customerlogin character varying(50)
);


ALTER TABLE customer OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16836)
-- Name: customer_customerid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE customer_customerid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE customer_customerid_seq OWNER TO postgres;

--
-- TOC entry 2003 (class 0 OID 0)
-- Dependencies: 172
-- Name: customer_customerid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE customer_customerid_seq OWNED BY customer.customerid;


--
-- TOC entry 1881 (class 2604 OID 16841)
-- Name: customerid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customer ALTER COLUMN customerid SET DEFAULT nextval('customer_customerid_seq'::regclass);


--
-- TOC entry 1994 (class 0 OID 16838)
-- Dependencies: 173
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO customer (customerid, customername, customerpassword, customerlogin) VALUES (6, 'Cindy', '7412', 'Okino');
INSERT INTO customer (customerid, customername, customerpassword, customerlogin) VALUES (4, 'Maya', '45236)', 'Cao');
INSERT INTO customer (customerid, customername, customerpassword, customerlogin) VALUES (7, 'julio', 'hue123', 'sauer');
INSERT INTO customer (customerid, customername, customerpassword, customerlogin) VALUES (3, 'Evandro', '123456', 'Machadoa');
INSERT INTO customer (customerid, customername, customerpassword, customerlogin) VALUES (5, 'Meggy', '78569)', 'Cao2');
INSERT INTO customer (customerid, customername, customerpassword, customerlogin) VALUES (10, 'Edson', '987654', 'Balao');


--
-- TOC entry 2004 (class 0 OID 0)
-- Dependencies: 172
-- Name: customer_customerid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('customer_customerid_seq', 10, true);


--
-- TOC entry 1883 (class 2606 OID 16843)
-- Name: pkidcliente; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT pkidcliente PRIMARY KEY (customerid);


--
-- TOC entry 2001 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-03-12 09:47:23

--
-- PostgreSQL database dump complete
--

