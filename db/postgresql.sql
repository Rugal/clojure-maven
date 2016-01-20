--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: course; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE course (
    cid integer NOT NULL,
    name character varying(20)
);


ALTER TABLE public.course OWNER TO postgres;

--
-- Name: registration; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE registration (
    rid integer NOT NULL,
    cid integer,
    sid integer
);


ALTER TABLE public.registration OWNER TO postgres;

--
-- Name: student; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student (
    sid integer NOT NULL,
    name character varying(20)
);


ALTER TABLE public.student OWNER TO postgres;

--
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY course (cid, name) FROM stdin;
1	Math
2	C
3	C++
4	Java
5	Clojure
6	Database
\.


--
-- Data for Name: registration; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY registration (rid, cid, sid) FROM stdin;
1	1	1
2	1	2
3	1	3
4	1	4
5	2	1
6	2	4
7	3	3
8	3	1
9	4	4
10	4	1
11	5	1
12	5	3
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student (sid, name) FROM stdin;
1	Rugal
2	Bernstein
3	Tenjin
4	Descend
\.


--
-- Name: course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_pkey PRIMARY KEY (cid);


--
-- Name: registration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY registration
    ADD CONSTRAINT registration_pkey PRIMARY KEY (rid);


--
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (sid);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

