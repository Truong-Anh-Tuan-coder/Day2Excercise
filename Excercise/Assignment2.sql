--drop table section.
drop table WAREHOUSE_USER;
drop table WAREHOUSE_PRODUCT;
drop table WAREHOUSE;
drop table WAREHOUSE_ROLE;


--create new table section.
Create table WAREHOUSE_ROLE(
    ROLEID      number      generated as IDENTITY,
    ROLENAME    varchar2(50),
    PRIMARY KEY (ROLEID)
);

create table WAREHOUSE(
    WAREHOUSEID     number     GENERATED AS IDENTITY,
    WAREHOUSENAME   VARCHAR2(50)                    ,
    PRIMARY KEY ( WAREHOUSEID)
);

Create table WAREHOUSE_USER(
    USERID      number      generated as IDENTITY,
    USERNAME    varchar2(50) ,
    PASSWORD    varchar2(50),
    ROLEID      number      ,
    WAREHOUSEID number      ,
    PRIMARY KEY (USERID),
    CONSTRAINT fk_ROLE_USER FOREIGN KEY (ROLEID)
        REFERENCES WAREHOUSE_ROLE (ROLEID),
    CONSTRAINT fk_WAREHOUSE_USER FOREIGN KEY(WAREHOUSEID)
        REFERENCES WAREHOUSE(WAREHOUSEID)
);


Create table WAREHOUSE_PRODUCT(
    PRODUCTID       NUMBER  GENERATED AS IDENTITY,
    PRODUCENAME     VARCHAR2(50)                 ,
    DESCRIPTION     VARCHAR2(100)                ,
    QUANTITY        NUMBER                       ,
    PRICE           NUMBER                       ,
    WAREHOUSEID     NUMBER                       ,
    PRIMARY KEY (PRODUCTID)                      ,
    constraint fk_WAREHOUSE_PRODUCT FOREIGN KEY( WAREHOUSEID)
        REFERENCES WAREHOUSE(WAREHOUSEID)
);

INSERT INTO WAREHOUSE_ROLE (ROLENAME)
    VALUES ('Admin');
INSERT INTO WAREHOUSE_ROLE (ROLENAME)
    VALUES ('User');
    
INSERT INTO WAREHOUSE (warehousename)
    VALUES ('WareHouse_1');
INSERT INTO WAREHOUSE (warehousename)
    VALUES ('WareHouse_2');
INSERT INTO WAREHOUSE (warehousename)
    VALUES ('WareHouse_3');

INSERT INTO WAREHOUSE_PRODUCT(PRODUCENAME,DESCRIPTION,QUANTITY,PRICE,WAREHOUSEID)
    VALUES ('product name', 'description' , 10, 100, 1);
    
--insert for admin 
INSERT INTO WAREHOUSE_USER (USERNAME,PASSWORD,ROLEID)
    VALUES('Admin','Admin', 1);


INSERT INTO WAREHOUSE_USER (USERNAME,PASSWORD,ROLEID, WAREHOUSEID)
    VALUES('User_1','User_1', 2,1);
INSERT INTO WAREHOUSE_USER (USERNAME,PASSWORD,ROLEID, WAREHOUSEID)
    VALUES('User_2','User_2', 2,2);
INSERT INTO WAREHOUSE_USER (USERNAME,PASSWORD,ROLEID)
    VALUES('User_3','User_3', 2);



