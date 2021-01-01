# clojuredocs-export-edn

![build](https://github.com/clojure-emacs/clojuredocs-export-edn/workflows/build/badge.svg)
[![Dependencies Status](https://versions.deps.co/clojure-emacs/clojuredocs-export-edn/status.svg)](https://versions.deps.co/clojure-emacs/clojuredocs-export-edn)

A simple tool that converts [ClojureDocs](https://clojuredocs.org)'s
[clojuredocs-export.json](https://clojuredocs.org/clojuredocs-export.json)
to EDN format, and publishes the EDN export (in several variants) to this repository daily.

## Why?

Because ClojureDocs doesn't have an official API and provides only a JSON export of its data currently. This makes
it harder for tools to leverage ClojureDocs and the EDN exports aim to bridge that gap.

This EDN data is used by libraries like [Orchard](https://github.com/clojure-emacs/orchard) to fuse ClojureDocs and the standard Clojure documentation.

## Exported Data

The EDN data is made available in several variants:

* A EDN file containing all the data from the JSON export is [here](https://github.com/clojure-emacs/clojuredocs-export-edn/blob/master/exports/export.edn).
* A compact EDN file (it doesn't include data about edits that were made to the data, only its current state) is [here](https://github.com/clojure-emacs/clojuredocs-export-edn/blob/master/exports/export.compact.edn).
* A compact minified EDN file (it strips all the optional whitespace) is [here](https://github.com/clojure-emacs/clojuredocs-export-edn/blob/master/exports/export.compact.min.edn).

Probably most people will be best served by the final variant (`export.compact.min.edn`).

## Running the Exporter

You can also run the export procedure manually like this:

    $ lein run

The fresh exports will be placed under `exports/`.

## License

Copyright © 2019-2020 [Masashi Iizuka](https://twitter.com/uochan), Bozhidar Batsov

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
