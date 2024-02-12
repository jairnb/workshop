#!/bin/bash

# Database connection details
HOST="localhost"
PORT="5432"
DB_NAME="company_service"
USERNAME="root"
PASSWORD="password"

# Schema name to create
NEW_SCHEMA="new_schema_name"

# Connect to the database and create a new schema
#psql -h $HOST -p $PORT -U $USERNAME -d $DB_NAME -c "CREATE SCHEMA $NEW_SCHEMA;"

#PGPASSWORD=$PASSWORD psql -X -h localhost -p $PORT -U $USERNAME -d $DB_NAME -c "CREATE SCHEMA $NEW_SCHEMA;"


#docker start postgres

#docker exec -it da0818b8a546 psql -U $USERNAME -d $DB_NAME -c "CREATE SCHEMA $NEW_SCHEMA;"

docker exec -it da0818b8a546 psql -U root -c "CREATE DATABASE my_schema"

echo "Schema $NEW_SCHEMA created successfully."