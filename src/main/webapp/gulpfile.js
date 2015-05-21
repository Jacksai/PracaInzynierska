(function(){

  'use strict';

  var gulp = require('gulp'),
      gutil = require('gulp-util'),
      jshint = require('gulp-jshint');

  gulp.task('default', ['watch']);

  //configure jshint task
  gulp.task('jshint', function(){
    return gulp.src(['**/*.js','!./node_modules/**/*.js','!./libs/*.js'])
    .pipe(jshint())
    .pipe(jshint.reporter('jshint-stylish'));
  });

  //configure files for watching
  gulp.task('watch', function() {
    gulp.watch(['**/*.js','!./node_modules/**','!./libs/**'], ['jshint']);
  });

})();
