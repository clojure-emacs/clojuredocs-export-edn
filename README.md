# clojuredocs-export-edn
[![CircleCI](https://img.shields.io/circleci/project/github/liquidz/clojuredocs-export-edn/master.svg)](https://circleci.com/gh/liquidz/clojuredocs-export-edn)
[![Dependencies Status](https://versions.deps.co/liquidz/clojuredocs-export-edn/status.svg)](https://versions.deps.co/liquidz/clojuredocs-export-edn)


Convert [ClojureDocs](https://clojuredocs.org)'s [clojuredocs-export.json](https://clojuredocs.org/clojuredocs-export.json) to EDN format, and deploy to [Netlify](https://www.netlify.com) daily.

* Deployed EDN file
  * https://clojuredocs-edn.netlify.com/export.edn
  * https://clojuredocs-edn.netlify.com/export.compact.edn
* Deploy task
  * https://github.com/liquidz/clojuredocs-export-edn/blob/master/.circleci/config.yml

## How to deploy to netlify

* EDN files are deployed by CircleCI automatically.
  * All steps are in [.circleci/config.yml](.circleci/config.yml).
    * The job is triggered by cron [every day](https://github.com/liquidz/clojuredocs-export-edn/blob/b9edb899e0a5402fc82f43afa72cb61e047545bf/.circleci/config.yml#L48-L55).
* All you need is to add these environment variables to CircleCI.
  * `NETLIFY_PERSONAL_ACCESS_TOKEN` which can be created [here](https://app.netlify.com/user/applications#personal-access-tokens)
  * `NETLIFY_SITE_ID` which is your site's API ID
* Steps to deploy manually is below.
```console
# EDN files are generated in ./target/out/
bash generate.sh

# Install netlify-cli
sudo npm install -g --silent netlify-cli

# Deploy EDN files via netlify-cli
netlify deploy \
    --auth=${NETLIFY_PERSONAL_ACCESS_TOKEN} \
    --site=${NETLIFY_SITE_ID} \
    --dir=target/out \
    --prod
```

## License

Copyright © 2019 [Masashi Iizuka](https://twitter.com/uochan)

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
