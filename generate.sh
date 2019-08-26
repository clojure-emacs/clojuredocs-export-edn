#!/bin/sh

mkdir -p target/out
\cp -pf index.html target/out
lein test
