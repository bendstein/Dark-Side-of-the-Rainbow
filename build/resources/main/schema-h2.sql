-- noinspection SqlNoDataSourceInspectionForFile

-- Table for Albums

CREATE TABLE ALBUM (

    ID INTEGER PRIMARY KEY,
    TITLE CHARACTER VARYING,
    ARTISTNAME CHARACTER VARYING,
    RELEASE INTEGER,
    GENRE CHARACTER VARYING,
    TRACKS INTEGER,
    PRICE NUMERIC

);

/*

DROP SEQUENCE ALBUM_ID_SEQ;

 */


CREATE SEQUENCE ALBUM_ID_SEQ
    increment BY 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;



-- Table for artists


CREATE TABLE ARTIST (

    ARTISTID INTEGER PRIMARY KEY,
    ARTISTNAME CHARACTER VARYING

);


/*
DROP SEQUENCE ARTIST_ID_SEQ;

 */

CREATE SEQUENCE ARTIST_ID_SEQ
    increment BY 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;




-- Table for Users

CREATE TABLE APPLICATION_USER (

    USERID INTEGER PRIMARY KEY,
    USERNAME CHARACTER VARYING,
    PASSWORD CHARACTER VARYING,
    IS_ADMIN BOOLEAN

);


/*
DROP SEQUENCE APPLICATION_USER_ID_SEQ;

 */

CREATE SEQUENCE APPLICATION_USER_ID_SEQ
    increment BY 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;

