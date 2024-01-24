#!/bin/bash

liquibase generate-changelog \
--url=jdbc:postgresql://localhost:5432/test_graal_db \
--username=postgres \
--password=postgres \
--author=ihor.didyk \
--changelog-file=src/main/resources/db/changelog/master.xml
