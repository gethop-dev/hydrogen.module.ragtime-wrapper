# module.ragtime-wrapper

Duct module that wrapping configuration for Ragtime migrations. We got a feeling that writing them by hand takes way too much space in config.

Of course there are still some loose ends. For one, it could be more explicit about the ordering of migrations.

## Usage

Istead of adding `:migrations [#ig/ref ... #ig/ref ...]` and a bunch of key definitions just add this to your ragtime config:

```edn
:migrations-paths ["myproject/migrations/001-create-initial-schema"
                   "myproject/migrations/002-do-stuff"]
```

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
