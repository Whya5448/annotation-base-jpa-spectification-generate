insert into user_id
values ('82000174');
insert into employer
values ('개발부', '0001', '개발자', 'ENABLED', '82000174');

insert into user_id
values ('82000175');
insert into employer
values ('개발부', '0002', '안개발자', 'DELETED', '82000175');

insert into gateway_api_service
values (1, 'A Service');
insert into gateway_api_service
values (2, 'B Service');
insert into gateway_api_service
values (3, 'C Service');

insert into org
values (4, 'Q Org');
insert into org
values (5, 'W Org');

insert into gateway_api(id, name, desc, uri, service_id, org_id, create_id, state, create_date, update_date)
values (random_uuid(), 'Z Api', random_uuid(), '/Z', 1, 4, '82000174', 'ENABLED', '2020-07-21 01:21:36+09', now());

insert into gateway_api(id, name, desc, uri, service_id, org_id, create_id, state, create_date, update_date)
values (random_uuid(), 'ZZ Api', random_uuid(), '/ZZ', 2, 4, '82000174', 'SAVED', '2020-07-20 01:21:36+09', now());

insert into gateway_api(id, name, desc, uri, service_id, org_id, create_id, state, create_date, update_date)
values (random_uuid(), 'ZZZ Api', random_uuid(), '/ZZZ', 2, 4, '82000174', 'DELETED', '2020-07-19 01:21:36+09', now());

insert into gateway_api(id, name, desc, uri, service_id, org_id, create_id, state, create_date, update_date)
values (random_uuid(), 'X Api', random_uuid(), '/X', 1, 4, '82000175', 'ENABLED', '2020-07-18 01:21:36+09', now());

insert into gateway_api(id, name, desc, uri, service_id, org_id, create_id, state, create_date, update_date)
values (random_uuid(), 'XX Api', random_uuid(), '/XX', 1, 5, '82000175', 'SAVED', '2020-07-17 01:21:36+09', now());