/*
 * Copyright (c) 2010 by NPC International, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.grails.datastore.gorm

import org.springframework.datastore.mapping.core.Session
import org.springframework.datastore.mapping.keyvalue.mapping.KeyValueMappingContext
import org.springframework.datastore.mapping.riak.RiakDatastore

/**
 * @author Jon Brisbin <jon.brisbin@npcinternational.com>
 */
class Setup {

  static riak

  static Session setup(classes) {
    riak = new RiakDatastore(new KeyValueMappingContext(""))
    for (cls in classes) {
      riak.mappingContext.addPersistentEntity(cls)
    }
  }
}