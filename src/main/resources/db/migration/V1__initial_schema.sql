CREATE TABLE coffee_machine (
    id BIGSERIAL PRIMARY KEY
);

CREATE TABLE recipe (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE coffee_machine_recipe (
    id BIGSERIAL PRIMARY KEY,
    coffee_machine_id BIGINT NOT NULL REFERENCES coffee_machine(id),
    recipe_id BIGINT NOT NULL REFERENCES recipe(id)
);

CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    recipe_id BIGINT NOT NULL REFERENCES recipe(id),
    date TIMESTAMP NOT NULL
);
