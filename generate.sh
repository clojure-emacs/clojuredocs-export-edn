#!/bin/sh

mkdir -p target/out
lein run > target/out/export.edn
