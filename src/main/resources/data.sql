-- data.sql - generated with AI

-- United States: Standard 5-digit numeric
INSERT INTO postal_code (country_code, country_name, postal_code_format, validation_regex)
VALUES ('US', 'United States', '#####-####', '^\d{5}(-\\d{4})?$');

-- France: 5-digit numeric (starts with region code)
INSERT INTO postal_code (country_code, country_name, postal_code_format, validation_regex)
VALUES ('FR', 'France', '#####', '^(\d{5})$');

-- Germany: 5-digit numeric (Postleitzahl)
INSERT INTO postal_code (country_code, country_name, postal_code_format, validation_regex)
VALUES ('DE', 'Germany', '#####', '^(\d{5})$');

-- Netherlands: Alphanumeric (4 digits + 2 letters)
INSERT INTO postal_code (country_code, country_name, postal_code_format, validation_regex)
VALUES ('NL', 'Netherlands', '#### @@', '^(\d{4}[A-Z]{2})$');

-- United Arab Emirates: No postal code system (Null values)
INSERT INTO postal_code (country_code, country_name, postal_code_format, validation_regex)
VALUES ('AE', 'United Arab Emirates', NULL, NULL);

-- Brazil: 8-digit numeric with hyphen
INSERT INTO postal_code (country_code, country_name, postal_code_format, validation_regex)
VALUES ('BR', 'Brazil', '#####-###', '^(\d{8})$');