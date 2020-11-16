--
-- PostgreSQL database dump
--

-- Dumped from database version 10.14
-- Dumped by pg_dump version 10.14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: ecodoc; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA ecodoc;


ALTER SCHEMA ecodoc OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: map_category; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.map_category (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    client_id bigint,
    cat_id bigint,
    name character varying(255)
);


ALTER TABLE ecodoc.map_category OWNER TO postgres;

--
-- Name: map_category_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.map_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.map_category_id_seq OWNER TO postgres;

--
-- Name: map_category_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.map_category_id_seq OWNED BY ecodoc.map_category.id;


--
-- Name: permission; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.permission (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    client_id bigint,
    sys_module_id bigint,
    sys_role_id bigint
);


ALTER TABLE ecodoc.permission OWNER TO postgres;

--
-- Name: permission_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.permission_id_seq OWNER TO postgres;

--
-- Name: permission_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.permission_id_seq OWNED BY ecodoc.permission.id;


--
-- Name: sys_category; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_category (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    name character varying(255),
    order_number integer,
    super_admin boolean,
    client_id bigint,
    code character varying(255),
    category_type_id bigint NOT NULL,
    organization_id bigint,
    categorytype_id bigint,
    is_default boolean,
    sync_code bigint,
    is_ldap boolean
);


ALTER TABLE ecodoc.sys_category OWNER TO postgres;

--
-- Name: sys_category_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_category_id_seq OWNER TO postgres;

--
-- Name: sys_category_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_category_id_seq OWNED BY ecodoc.sys_category.id;


--
-- Name: sys_category_type; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_category_type (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    name character varying(50),
    super_admin boolean,
    client_id bigint,
    code character varying(255),
    is_default boolean
);


ALTER TABLE ecodoc.sys_category_type OWNER TO postgres;

--
-- Name: sys_category_type_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_category_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_category_type_id_seq OWNER TO postgres;

--
-- Name: sys_category_type_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_category_type_id_seq OWNED BY ecodoc.sys_category_type.id;


--
-- Name: sys_clients; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_clients (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    address character varying(255),
    customer_type bigint,
    name character varying(255),
    phone character varying(255),
    code character varying(255),
    salt character varying(255)
);


ALTER TABLE ecodoc.sys_clients OWNER TO postgres;

--
-- Name: sys_clients_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_clients_id_seq OWNER TO postgres;

--
-- Name: sys_clients_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_clients_id_seq OWNED BY ecodoc.sys_clients.id;


--
-- Name: sys_module; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_module (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    client_id bigint,
    code character varying(255),
    component_name character varying(255),
    description character varying(255),
    expanded boolean,
    fa_icon character varying(255),
    is_default boolean,
    is_parent boolean,
    name character varying(255),
    order_number bigint,
    parent_id bigint,
    router_path character varying(255)
);


ALTER TABLE ecodoc.sys_module OWNER TO postgres;

--
-- Name: sys_module_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_module_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_module_id_seq OWNER TO postgres;

--
-- Name: sys_module_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_module_id_seq OWNED BY ecodoc.sys_module.id;


--
-- Name: sys_organization; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_organization (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    client_id bigint,
    address character varying(255),
    code bigint,
    email character varying(255),
    expiry_date timestamp without time zone,
    id_cat bigint,
    is_ldap boolean,
    level integer,
    name character varying(255),
    note character varying(255),
    order_number integer,
    org_type bigint,
    parent_id bigint,
    phone character varying(255),
    root_id bigint,
    shortcut character varying(255),
    org_id_sync bigint
);


ALTER TABLE ecodoc.sys_organization OWNER TO postgres;

--
-- Name: sys_organization_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_organization_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_organization_id_seq OWNER TO postgres;

--
-- Name: sys_organization_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_organization_id_seq OWNED BY ecodoc.sys_organization.id;


--
-- Name: sys_position_role; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_position_role (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    client_id bigint,
    sys_position_id bigint,
    sys_role_id bigint
);


ALTER TABLE ecodoc.sys_position_role OWNER TO postgres;

--
-- Name: sys_position_role_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_position_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_position_role_id_seq OWNER TO postgres;

--
-- Name: sys_position_role_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_position_role_id_seq OWNED BY ecodoc.sys_position_role.id;


--
-- Name: sys_role; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_role (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    client_id bigint,
    is_default boolean,
    name character varying(255)
);


ALTER TABLE ecodoc.sys_role OWNER TO postgres;

--
-- Name: sys_role_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_role_id_seq OWNER TO postgres;

--
-- Name: sys_role_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_role_id_seq OWNED BY ecodoc.sys_role.id;


--
-- Name: sys_strace; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_strace (
    id bigint NOT NULL,
    action character varying(255),
    id_client bigint,
    content text,
    id_content bigint,
    create_date timestamp without time zone,
    id_cat bigint,
    ip_device character varying(50),
    name_device character varying(50),
    username character varying(255) NOT NULL
);


ALTER TABLE ecodoc.sys_strace OWNER TO postgres;

--
-- Name: sys_strace_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_strace_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_strace_id_seq OWNER TO postgres;

--
-- Name: sys_strace_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_strace_id_seq OWNED BY ecodoc.sys_strace.id;


--
-- Name: sys_user; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_user (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    birthday timestamp without time zone,
    change_pass boolean,
    email character varying(100),
    employee_code character varying(255),
    employee_id bigint,
    expiry_pass timestamp without time zone,
    full_name character varying(100),
    indentity character varying(20),
    last_login timestamp without time zone,
    password character varying(100),
    phone character varying(20),
    photo character varying(100),
    salt character varying(255),
    serial_token character varying(255),
    signature character varying(255),
    title character varying(50),
    user_name character varying(255),
    client_id bigint,
    org_id bigint NOT NULL,
    position_id bigint,
    lead boolean,
    organization bytea,
    default_role bigint,
    gender bigint,
    curr_role bigint,
    address character varying(255),
    phone_ca character varying(255),
    phone_ca_provider character varying(255),
    is_ldap boolean,
    expired_time_token character varying(255),
    name_token character varying(255),
    org_token character varying(255),
    start_time_token character varying(255)
);


ALTER TABLE ecodoc.sys_user OWNER TO postgres;

--
-- Name: sys_user_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_user_id_seq OWNER TO postgres;

--
-- Name: sys_user_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_user_id_seq OWNED BY ecodoc.sys_user.id;


--
-- Name: sys_user_role; Type: TABLE; Schema: ecodoc; Owner: postgres
--

CREATE TABLE ecodoc.sys_user_role (
    id bigint NOT NULL,
    active boolean,
    create_by bigint,
    create_date timestamp without time zone,
    update_by bigint,
    update_date timestamp without time zone,
    client_id bigint,
    sys_role_id bigint,
    sys_user_id bigint
);


ALTER TABLE ecodoc.sys_user_role OWNER TO postgres;

--
-- Name: sys_user_role_id_seq; Type: SEQUENCE; Schema: ecodoc; Owner: postgres
--

CREATE SEQUENCE ecodoc.sys_user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ecodoc.sys_user_role_id_seq OWNER TO postgres;

--
-- Name: sys_user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: ecodoc; Owner: postgres
--

ALTER SEQUENCE ecodoc.sys_user_role_id_seq OWNED BY ecodoc.sys_user_role.id;


--
-- Name: map_category id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.map_category ALTER COLUMN id SET DEFAULT nextval('ecodoc.map_category_id_seq'::regclass);


--
-- Name: permission id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.permission ALTER COLUMN id SET DEFAULT nextval('ecodoc.permission_id_seq'::regclass);


--
-- Name: sys_category id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_category_id_seq'::regclass);


--
-- Name: sys_category_type id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category_type ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_category_type_id_seq'::regclass);


--
-- Name: sys_clients id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_clients ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_clients_id_seq'::regclass);


--
-- Name: sys_module id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_module ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_module_id_seq'::regclass);


--
-- Name: sys_organization id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_organization ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_organization_id_seq'::regclass);


--
-- Name: sys_position_role id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_position_role ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_position_role_id_seq'::regclass);


--
-- Name: sys_role id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_role ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_role_id_seq'::regclass);


--
-- Name: sys_strace id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_strace ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_strace_id_seq'::regclass);


--
-- Name: sys_user id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_user_id_seq'::regclass);


--
-- Name: sys_user_role id; Type: DEFAULT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user_role ALTER COLUMN id SET DEFAULT nextval('ecodoc.sys_user_role_id_seq'::regclass);


--
-- Data for Name: map_category; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.map_category (id, active, create_by, create_date, update_by, update_date, client_id, cat_id, name) FROM stdin;
\.


--
-- Data for Name: permission; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.permission (id, active, create_by, create_date, update_by, update_date, client_id, sys_module_id, sys_role_id) FROM stdin;
26	t	1	2020-05-15 10:52:55.792	3	2020-07-07 12:25:44.443	1	10	1
27	t	1	2020-05-15 10:52:55.823	3	2020-07-07 12:25:44.468	1	9	1
28	t	1	2020-05-15 10:52:55.843	3	2020-07-07 12:25:44.497	1	20	1
29	t	1	2020-05-15 10:52:55.864	3	2020-07-07 12:25:44.519	1	7	1
2	t	1	2020-05-14 14:26:54.544	3	2020-07-07 12:25:44.535	1	8	1
18	t	1	2020-05-14 22:43:43.953	1	2020-05-15 12:22:57.446	1	2	1
379	t	3	2020-07-06 21:14:33.557	3	2020-07-06 21:14:33.557	1	28	1
380	t	3	2020-07-06 21:14:33.56	3	2020-07-06 21:14:33.56	1	29	1
382	t	3	2020-07-06 21:14:33.567	3	2020-07-06 21:14:33.567	1	33	1
730	t	1	2020-08-19 13:40:35.298	1	2020-09-25 02:54:21.129	1	6	1
723	t	1	2020-08-19 13:40:35.151	1	2020-08-20 00:03:08.703	1	25	1
729	t	1	2020-08-19 13:40:35.284	1	2020-09-25 02:54:21.129	1	11	1
770	t	1	2020-09-25 09:22:43.255	1	2020-09-25 09:22:43.255	1	27	1
771	t	1	2020-09-25 09:22:43.293	1	2020-09-25 09:22:43.293	1	3	1
\.


--
-- Data for Name: sys_category; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_category (id, active, create_by, create_date, update_by, update_date, name, order_number, super_admin, client_id, code, category_type_id, organization_id, categorytype_id, is_default, sync_code, is_ldap) FROM stdin;
260	f	1	2020-09-11 23:46:48.782	1	2020-09-17 11:06:05.656	Quản trị	8	\N	1	\N	14	25	\N	\N	\N	\N
\.


--
-- Data for Name: sys_category_type; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_category_type (id, active, create_by, create_date, update_by, update_date, name, super_admin, client_id, code, is_default) FROM stdin;
14	t	2	2020-06-03 16:53:13.177	1	2020-07-21 21:42:19.244	Chức vụ	f	1	CVND	\N
\.


--
-- Data for Name: sys_clients; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_clients (id, active, create_by, create_date, update_by, update_date, address, customer_type, name, phone, code, salt) FROM stdin;
1	t	\N	2020-10-02 11:28:56	\N	\N	\N	\N	Quản trị vận hành EcoOffice		H05	eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNzU1Njc0NTgzMDAwIiwiaWF0IjoxNTk3OTEyMTY3LCJleHAiOjIxNTcxMTIxNjd9.DPZw0O3Vn9fbue4X_44UCIe0dLciNb89vqAm9nih1u7i58DA9Zg-gv9u3J4kA2Gx9ZC_-KZcX-div6Aj8ifreQ
\.


--
-- Data for Name: sys_module; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_module (id, active, create_by, create_date, update_by, update_date, client_id, code, component_name, description, expanded, fa_icon, is_default, is_parent, name, order_number, parent_id, router_path) FROM stdin;
2	t	1	2020-05-10 20:26:08.878	1	2020-05-14 12:24:12.453	1	ADMIN	./modules/admin/admin.module#AdminModule	\N	\N	icon-Wrench	t	t	Quản trị hệ thống	89	\N	admin
27	t	1	2020-05-10 20:26:20.514	1	2020-05-14 12:24:12.453	1	LOG_SYSTEM		\N	\N		t	t	Log hệ thống	4	3	/log
7	t	1	2020-05-10 21:07:53.264	1	2020-05-14 11:12:12.982	1	USER	\N	\N	\N		t	f	Người dùng	2	2	/users
28	t	1	2020-05-11 13:36:56.56	1	2020-05-14 11:12:12.982	1	FORM	\N	\N	\N		t	f	Cấu hình Form	6	2	/form
10	t	1	2020-05-10 21:08:07.499	1	2020-05-14 11:12:12.983	1	CATEGORY	\N	\N	\N		t	f	Danh mục	2	2	/categories
9	t	1	2020-05-10 21:08:02.545	1	2020-05-14 11:12:12.981	1	ORG	\N	\N	\N		t	f	Đơn vị	2	2	/organizations
29	t	1	2020-05-10 20:27:20.514	1	2020-05-14 11:12:12.982	1	LOG_BUSINESS\r\n	\N	\N	\N	\N	t	t	Log nghiệp vụ	2	2	/log-business
33	t	1	2020-05-11 13:36:56.56	1	2020-05-14 11:12:12.982	1	DOCUMENT_BOOK	\N	\N	\N		t	f	Sổ văn bản	6	2	/document-book
6	t	1	2020-05-10 20:26:48.501	3	2020-05-19 11:43:11.905	1	CALENDAR	./modules/calendar/calendarfull.module#CalendarfullModule	\N	f	icon-Calendar-4	t	t	Lịch	799	\N	calendar
25	t	1	2020-05-10 20:26:20.514	1	2020-05-14 12:24:12.453	1	DASHBOARD	./modules/operation/operation.module#OperationModule	\N	f	icon-Home	t	t	Bảng điều khiển	1000	\N	/
20	t	1	\N	1	\N	1	PROCESS	\N	\N	\N	\N	t	f	Luồng	2	2	/process
8	t	1	2020-05-10 21:07:57.11	1	2020-05-14 11:12:12.981	1	ROLE	\N	\N	f		t	f	Phân quyền vai trò	3	2	/role
11	t	1	2020-05-11 13:36:56.56	1	2020-05-14 11:12:12.982	1	CAL_PERSON		\N	f		t	f	Lịch làm việc	6	6	/calendar/person
3	t	1	2020-05-10 20:26:20.514	1	2020-05-14 12:24:12.453	1	OPERATION	./modules/operation/operation.module#OperationModule	\N	f	icon-Car-Wheel	t	t	Quản trị vận hành	99	\N	operation
\.


--
-- Data for Name: sys_organization; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_organization (id, active, create_by, create_date, update_by, update_date, client_id, address, code, email, expiry_date, id_cat, is_ldap, level, name, note, order_number, org_type, parent_id, phone, root_id, shortcut, org_id_sync) FROM stdin;
25	t	\N	2020-08-19 10:10:40.531	\N	2020-08-19 10:10:40.531	1	\N	133413	\N	\N	\N	t	0	ECOIT	\N	\N	\N	\N	\N	\N	\N	\N
\.


--
-- Data for Name: sys_position_role; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_position_role (id, active, create_by, create_date, update_by, update_date, client_id, sys_position_id, sys_role_id) FROM stdin;
16	t	1	2020-09-11 23:47:31.422	1	2020-09-11 23:47:31.422	1	260	1
\.


--
-- Data for Name: sys_role; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_role (id, active, create_by, create_date, update_by, update_date, client_id, is_default, name) FROM stdin;
1	t	1	2020-05-10 20:41:40.114	1	2020-06-30 21:54:40.594	1	t	Vận hành hệ thống
\.


--
-- Data for Name: sys_strace; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_strace (id, action, id_client, content, id_content, create_date, id_cat, ip_device, name_device, username) FROM stdin;
1	login	1	admin	1	2020-10-02 17:46:08.775	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
2	login	1	admin	1	2020-10-02 17:46:19.016	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
3	login	1	admin	1	2020-10-02 17:47:06.045	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
4	login	1	admin	1	2020-10-02 18:13:58.644	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
5	login	1	admin	1	2020-10-02 18:17:07.207	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
6	login	1	admin	1	2020-10-02 18:18:10.454	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
7	login	1	admin	1	2020-10-04 11:03:43.95	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
8	login	1	admin	1	2020-10-04 11:14:46.314	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
9	login	1	admin	1	2020-10-05 08:33:42.365	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
10	login	1	admin	1	2020-10-05 08:48:05.537	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
11	login	1	admin	1	2020-10-05 08:48:15.021	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
12	login	1	admin	1	2020-10-05 10:34:23.557	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
13	login	1	admin	1	2020-10-05 10:39:25.986	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
14	login	1	admin	1	2020-10-05 10:51:01.842	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
15	login	1	admin	1	2020-10-05 10:51:04.902	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
16	login	1	admin	1	2020-10-05 10:55:26.739	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
17	login	1	admin	1	2020-10-05 11:13:27.405	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
18	login	1	admin	1	2020-10-05 11:16:09.159	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
19	login	1	admin	1	2020-10-05 11:17:11.791	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
20	login	1	admin	1	2020-10-05 11:21:14.41	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
21	login	1	admin	1	2020-10-05 11:35:52.149	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
22	login	1	admin	1	2020-10-05 11:54:08.735	2	0:0:0:0:0:0:0:1	0:0:0:0:0:0:0:1	admin
\.


--
-- Data for Name: sys_user; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_user (id, active, create_by, create_date, update_by, update_date, birthday, change_pass, email, employee_code, employee_id, expiry_pass, full_name, indentity, last_login, password, phone, photo, salt, serial_token, signature, title, user_name, client_id, org_id, position_id, lead, organization, default_role, gender, curr_role, address, phone_ca, phone_ca_provider, is_ldap, expired_time_token, name_token, org_token, start_time_token) FROM stdin;
1	t	\N	2020-08-19 13:58:59.548	1	2020-10-01 21:28:09.924	1985-01-16 19:00:00	f	postmaster@ecoit.asia	\N	\N	\N	Administrator	654654654645	2020-10-05 11:54:08.721	$2a$10$vAfqcSlv2nRjQMgmTzk76eyl2WQpewy9BVJDcvXGUfAxIq8aIHkRe	\N	https://michaeleisenbraun.com/images/sp-developer.png	\N	\N		Quản trị vận hành hệ thống	admin	1	25	260	f	\N	1	0	1	\N	\N	\N	f	\N	\N	\N	\N
\.


--
-- Data for Name: sys_user_role; Type: TABLE DATA; Schema: ecodoc; Owner: postgres
--

COPY ecodoc.sys_user_role (id, active, create_by, create_date, update_by, update_date, client_id, sys_role_id, sys_user_id) FROM stdin;
1	f	1	2020-05-14 09:10:55.73	1	2020-09-11 23:47:27.72	1	1	1
\.


--
-- Name: map_category_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.map_category_id_seq', 1, false);


--
-- Name: permission_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.permission_id_seq', 1, false);


--
-- Name: sys_category_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_category_id_seq', 1, false);


--
-- Name: sys_category_type_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_category_type_id_seq', 1, true);


--
-- Name: sys_clients_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_clients_id_seq', 1, false);


--
-- Name: sys_module_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_module_id_seq', 1, false);


--
-- Name: sys_organization_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_organization_id_seq', 1, false);


--
-- Name: sys_position_role_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_position_role_id_seq', 1, false);


--
-- Name: sys_role_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_role_id_seq', 1, false);


--
-- Name: sys_strace_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_strace_id_seq', 22, true);


--
-- Name: sys_user_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_user_id_seq', 2, true);


--
-- Name: sys_user_role_id_seq; Type: SEQUENCE SET; Schema: ecodoc; Owner: postgres
--

SELECT pg_catalog.setval('ecodoc.sys_user_role_id_seq', 1, false);


--
-- Name: map_category map_category_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.map_category
    ADD CONSTRAINT map_category_pkey PRIMARY KEY (id);


--
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


--
-- Name: sys_category sys_category_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category
    ADD CONSTRAINT sys_category_pkey PRIMARY KEY (id);


--
-- Name: sys_category_type sys_category_type_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category_type
    ADD CONSTRAINT sys_category_type_pkey PRIMARY KEY (id);


--
-- Name: sys_clients sys_clients_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_clients
    ADD CONSTRAINT sys_clients_pkey PRIMARY KEY (id);


--
-- Name: sys_module sys_module_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_module
    ADD CONSTRAINT sys_module_pkey PRIMARY KEY (id);


--
-- Name: sys_organization sys_organization_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_organization
    ADD CONSTRAINT sys_organization_pkey PRIMARY KEY (id);


--
-- Name: sys_position_role sys_position_role_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_position_role
    ADD CONSTRAINT sys_position_role_pkey PRIMARY KEY (id);


--
-- Name: sys_role sys_role_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_role
    ADD CONSTRAINT sys_role_pkey PRIMARY KEY (id);


--
-- Name: sys_strace sys_strace_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_strace
    ADD CONSTRAINT sys_strace_pkey PRIMARY KEY (id);


--
-- Name: sys_user sys_user_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user
    ADD CONSTRAINT sys_user_pkey PRIMARY KEY (id);


--
-- Name: sys_user_role sys_user_role_pkey; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user_role
    ADD CONSTRAINT sys_user_role_pkey PRIMARY KEY (id);


--
-- Name: sys_organization uk1iw1ifxkb74p6o0q1ye7dvd03; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_organization
    ADD CONSTRAINT uk1iw1ifxkb74p6o0q1ye7dvd03 UNIQUE (client_id, name, parent_id);


--
-- Name: sys_organization uk1njjlxvs0v603yuvkuo3du6ux; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_organization
    ADD CONSTRAINT uk1njjlxvs0v603yuvkuo3du6ux UNIQUE (client_id, name);


--
-- Name: sys_user uk54pl0who5wb0q7i0bb3s5uo78; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user
    ADD CONSTRAINT uk54pl0who5wb0q7i0bb3s5uo78 UNIQUE (client_id, user_name);


--
-- Name: map_category uk_fnupdek7iqx7n9p7c4qj3fb3r; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.map_category
    ADD CONSTRAINT uk_fnupdek7iqx7n9p7c4qj3fb3r UNIQUE (cat_id);


--
-- Name: permission ukah5elstjb9rqdhdfdw5fa32t7; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.permission
    ADD CONSTRAINT ukah5elstjb9rqdhdfdw5fa32t7 UNIQUE (sys_module_id, sys_role_id);


--
-- Name: sys_user_role ukd5oqog9k10he4yj462fp81eeb; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user_role
    ADD CONSTRAINT ukd5oqog9k10he4yj462fp81eeb UNIQUE (sys_user_id, sys_role_id);


--
-- Name: sys_category ukmwmg9jieoiomjfq8t80knhxpa; Type: CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category
    ADD CONSTRAINT ukmwmg9jieoiomjfq8t80knhxpa UNIQUE (client_id, name, category_type_id);


--
-- Name: sys_user_role fk1ef5794xnbirtsnudta6p32on; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user_role
    ADD CONSTRAINT fk1ef5794xnbirtsnudta6p32on FOREIGN KEY (sys_role_id) REFERENCES ecodoc.sys_role(id);


--
-- Name: sys_category fk7b7j2j6yqefc8114kb4otqii7; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category
    ADD CONSTRAINT fk7b7j2j6yqefc8114kb4otqii7 FOREIGN KEY (category_type_id) REFERENCES ecodoc.sys_category_type(id);


--
-- Name: sys_position_role fk7b9jy6c491eif0rty1npa41dl; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_position_role
    ADD CONSTRAINT fk7b9jy6c491eif0rty1npa41dl FOREIGN KEY (sys_position_id) REFERENCES ecodoc.sys_category(id);


--
-- Name: sys_user fk7gwcpfm240g4nlua1w5urle2e; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user
    ADD CONSTRAINT fk7gwcpfm240g4nlua1w5urle2e FOREIGN KEY (position_id) REFERENCES ecodoc.sys_category(id);


--
-- Name: sys_category fk7ksu05kew4l29u0fhnqv2i2ne; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category
    ADD CONSTRAINT fk7ksu05kew4l29u0fhnqv2i2ne FOREIGN KEY (client_id) REFERENCES ecodoc.sys_clients(id);


--
-- Name: permission fkacol9i1p5qkrmbykb4g3s6ik2; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.permission
    ADD CONSTRAINT fkacol9i1p5qkrmbykb4g3s6ik2 FOREIGN KEY (sys_module_id) REFERENCES ecodoc.sys_module(id);


--
-- Name: sys_category_type fkcfdnag2dao496higjkdsejvhf; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_category_type
    ADD CONSTRAINT fkcfdnag2dao496higjkdsejvhf FOREIGN KEY (client_id) REFERENCES ecodoc.sys_clients(id);


--
-- Name: sys_user fkh83e18gbpcirmt45cl82s05xh; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user
    ADD CONSTRAINT fkh83e18gbpcirmt45cl82s05xh FOREIGN KEY (org_id) REFERENCES ecodoc.sys_organization(id);


--
-- Name: sys_position_role fkk6wlewr6m8gcrt0c6j5hy1po7; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_position_role
    ADD CONSTRAINT fkk6wlewr6m8gcrt0c6j5hy1po7 FOREIGN KEY (sys_role_id) REFERENCES ecodoc.sys_role(id);


--
-- Name: sys_user fkpnp3e4b7jnlack6g18cuuv6xj; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user
    ADD CONSTRAINT fkpnp3e4b7jnlack6g18cuuv6xj FOREIGN KEY (client_id) REFERENCES ecodoc.sys_clients(id);


--
-- Name: permission fkpycefuyv5nq97wfq8avbv5lum; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.permission
    ADD CONSTRAINT fkpycefuyv5nq97wfq8avbv5lum FOREIGN KEY (sys_role_id) REFERENCES ecodoc.sys_role(id);


--
-- Name: sys_user_role fksbjvgfdwwy5rfbiag1bwh9x2b; Type: FK CONSTRAINT; Schema: ecodoc; Owner: postgres
--

ALTER TABLE ONLY ecodoc.sys_user_role
    ADD CONSTRAINT fksbjvgfdwwy5rfbiag1bwh9x2b FOREIGN KEY (sys_user_id) REFERENCES ecodoc.sys_user(id);


--
-- PostgreSQL database dump complete
--

