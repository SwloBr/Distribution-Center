#!/bin/bash
set -e
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE cd2;
    CREATE DATABASE cd3;
    CREATE DATABASE cd4;
EOSQL