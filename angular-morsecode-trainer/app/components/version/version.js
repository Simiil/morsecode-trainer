'use strict';

angular.module('morsecodeTrainer.version', [
  'morsecodeTrainer.version.interpolate-filter',
  'morsecodeTrainer.version.version-directive'
])

.value('version', '0.1');
