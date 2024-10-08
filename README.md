[![ci-cd](https://github.com/gethop-dev/module.ragtime-wrapper/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/gethop-dev/module.ragtime-wrapper/actions/workflows/ci-cd.yml)
[![Clojars Project](https://img.shields.io/clojars/v/dev.gethop/hydrogen.module.ragtime-wrapper.svg)](https://clojars.org/dev.gethop/hydrogen.module.ragtime-wrapper)

# hydrogen.module.ragtime-wrapper

[Duct](https://github.com/duct-framework/duct) module that wraps the configuration for Ragtime migrations. We got a feeling that writing them by hand takes way too much space in config.

Of course there are still some loose ends. For one, it could be more explicit about the ordering of migrations.

## Installation

[![Clojars Project](https://clojars.org/dev.gethop/hydrogen.module.ragtime-wrapper/latest-version.svg)](https://clojars.org/dev.gethop/hydrogen.module.ragtime-wrapper)

## Usage

First of all the following key has to be added to the`config.edn`. Take into account that it's a module key, so it should be placed outside the :duct.profile/base key map.

``` edn
:hydrogen.module/ragtime-wrapper {}
```

Then instead of adding `:migrations [#ig/ref ... #ig/ref ...]` and a bunch of key definitions just add this to your ragtime config:

```edn
:migrations-paths ["myproject/migrations/001-create-initial-schema"
                   "myproject/migrations/002-do-stuff"]
```

A complete example:

``` edn
 :duct.migrator/ragtime
  {:database #ig/ref :duct.database/sql
   :logger #ig/ref :duct/logger
   :strategy :raise-error
   :migrations-paths ["myproject/migrations/001-create-initial-schema"
                      "myproject/migrations/002-do-stuff"]}
```

## License

Copyright (c) 2024 Biotz, SL.

The source code for the library is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
