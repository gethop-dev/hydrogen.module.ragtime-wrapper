# module.ragtime-wrapper

Duct module that wrapping configuration for Ragtime migrations. We got a feeling that writing them by hand takes way too much space in config.

Of course there are still some loose ends. For one, it could be more explicit about the ordering of migrations.

## Instalation
```
[hydrogen/module.ragtime-wrapper "0.1.0"]
```

## Usage

Istead of adding `:migrations [#ig/ref ... #ig/ref ...]` and a bunch of key definitions just add this to your ragtime config:

```edn
:migrations-paths ["myproject/migrations/001-create-initial-schema"
                   "myproject/migrations/002-do-stuff"]
```

## License

Copyright (c) 2019, 2020 Magnet S Coop.

The source code for the library is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
