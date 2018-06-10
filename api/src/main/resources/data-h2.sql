
insert into skeleton.skltn_student values
(1, 'Fulano', 'E1234567'),
(2, 'Ciclano', 'A1234568');

alter sequence STUDENT_ID_SEQ restart with 3;

insert into skeleton.skltn_car values
(1, 'Vectra CD', 1),
(2, 'Omega CD', 1);

alter sequence CAR_ID_SEQ restart with 3;