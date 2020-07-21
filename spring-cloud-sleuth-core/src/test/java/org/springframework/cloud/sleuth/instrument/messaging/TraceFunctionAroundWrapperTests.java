/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.sleuth.instrument.messaging;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class TraceFunctionAroundWrapperTests {

	@Test
	void should_clear_cache_on_refresh() {
		TraceFunctionAroundWrapper wrapper = new TraceFunctionAroundWrapper(null, null);
		wrapper.functionToDestinationCache.put("example", "entry");
		then(wrapper.functionToDestinationCache).isNotEmpty();

		wrapper.onApplicationEvent(null);

		then(wrapper.functionToDestinationCache).isEmpty();
	}

}
