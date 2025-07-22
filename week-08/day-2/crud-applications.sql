# CRUD APPLICATIONS

# Databases have many operations, but often, they're broken down into four main categories:
-- Create = add one or more new records to one or more tables
-- Read = get the information from one or more database records without changing anything
-- Update = change some or all of the information in one or more database records
-- Delete = completely remove one or more database records

# For REST APIs and HTTP Requests, the terminology is a little different
-- Create -> POST request
-- Read -> GET request
-- Update -> PUT or PATCH request
-- Delete -> DELETE

# SQL Commands that match
-- Create -> INSERT
-- Read -> SELECT
-- Update -> UPDATE
-- Delete -> DELETE

# A NOTE ON PUT VS. PATCH
-- PUT should overwrite ALL fields in a DB record, even if the values have not changed
-- PATCH should overwrite ONLY what has changed

