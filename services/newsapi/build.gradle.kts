/*
 * Copyright (c) 2018 Zac Sweers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
  id("com.android.library")
  kotlin("android")
  alias(libs.plugins.moshix)
  alias(libs.plugins.sgp.base)
}

android {
  defaultConfig {
    buildConfigField("String", "NEWS_API_API_KEY",
        "\"${project.properties["catchup_news_api_api_key"].toString()}\"")
  }
}

slack {
  features {
    compose()
  }
}

dependencies {
  implementation(project(":libraries:util"))
  implementation(libs.misc.okio)
  implementation(libs.moshi.core)
  implementation(libs.retrofit.core)
  implementation(libs.retrofit.moshi)
  implementation(libs.retrofit.rxJava3)
  implementation(libs.okhttp.core)
  implementation(libs.misc.moshiLazyAdapters)

  api(project(":service-api"))
  api(libs.androidx.annotations)
  api(libs.dagger.runtime)
  api(libs.rx.java)
}
