INSERT INTO image
VALUES (nextval('image_seq'), 'first image'),
       (nextval('image_seq'), 'second image'),
       (nextval('image_seq'), 'third image'),
       (nextval('image_seq'), 'fourth image'),
       (nextval('image_seq'), 'fifth image')
;

INSERT INTO container
VALUES (nextval('container_seq'), (SELECT id FROM image WHERE image_name = 'first image'), 'first container'),
       (nextval('container_seq'), (SELECT id FROM image WHERE image_name = 'third image'), 'third container'),
       (nextval('container_seq'), (SELECT id FROM image WHERE image_name = 'fourth image'), 'fourth container'),
       (nextval('container_seq'), (SELECT id FROM image WHERE image_name = 'fifth image'), 'fifth container')
;