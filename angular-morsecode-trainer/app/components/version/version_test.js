'use strict';

describe('morsecodeTrainer.version module', function() {
  beforeEach(module('morsecodeTrainer.version'));

  describe('version service', function() {
    it('should return current version', inject(function(version) {
      expect(version).toEqual('0.1');
    }));
  });
});
