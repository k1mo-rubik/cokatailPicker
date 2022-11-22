
insert into types (id, name) values (1, 'Alcoholic');
insert into types (id, name) values (2, 'Non-Alcoholic');

insert into ingredients (id, name) values (1, 'Vodka');
insert into ingredients (id, name) values (2, 'Gin');
insert into ingredients (id, name) values (3, 'Rum');
insert into ingredients (id, name) values (4, 'Tequila');
insert into ingredients (id, name) values (5, 'Triple Sec');
insert into ingredients (id, name) values (6, 'Lime Juice');
insert into ingredients (id, name) values (7, 'Lemon Juice');
insert into ingredients (id, name) values (8, 'Sugar Syrup');
insert into ingredients (id, name) values (9, 'Cranberry Juice');
insert into ingredients (id, name) values (10, 'Orange Juice');
insert into ingredients (id, name) values (11, 'Grenadine');
insert into ingredients (id, name) values (12, 'Coca-Cola');
insert into ingredients (id, name) values (13, 'Ginger Ale');
insert into ingredients (id, name) values (14, 'Soda Water');
insert into ingredients (id, name) values (15, 'Mint Leaves');
insert into ingredients (id, name) values (16, 'Ice');
insert into ingredients (id, name) values (17, 'Lemon Slice');
insert into ingredients (id, name) values (18, 'Orange Slice');

insert into cocktails (id, name, type, picture) values (1, 'Mojito', 1, 'https://www.thecocktaildb.com/images/media/drink/3pylqc1504370988.jpg');

insert into cocktails_ingredients (cocktail_id, ingredient_id) values (1, 1);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (1, 6);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (1, 8);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (1, 15);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (1, 16);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (1, 17);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (1, 18);

insert into cocktails (id, name, type, picture) values (2, 'Long Island Iced Tea', 1, 'https://www.thecocktaildb.com/images/media/drink/xtuyqv1472668972.jpg');

insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 1);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 2);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 3);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 4);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 5);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 10);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 12);
insert into cocktails_ingredients (cocktail_id, ingredient_id) values (2, 16);

