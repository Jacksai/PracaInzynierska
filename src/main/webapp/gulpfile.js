(function(){

  'use strict';
  var gulp = require('gulp'),
      jshint = require('gulp-jshint'),
      sass = require('gulp-sass'),
      includeSources = require('gulp-include-source');


  gulp.task('default', ['watch']);

    //configure jshint task
    gulp.task('jshint', function(){
        return gulp.src(['**/*.js','!./node_modules/**/*.js','!./libs/*.js'])
            .pipe(jshint())
            .pipe(jshint.reporter('jshint-stylish'));
    });

    gulp.task('sass', function () {
       gulp.src('./styles/main.scss')
           .pipe(sass().on('error', sass.logError))
           .pipe(gulp.dest('./styles'));
    });

    gulp.task('html', function () {
        return gulp.src('index.html')
            .pipe(includeSources())
            .pipe(gulp.dest('WEB-INF/'));
    });

  //configure files for watching
  gulp.task('watch', function() {
      gulp.watch(['**/*.js','!./node_modules/**','!./libs/**'], ['jshint', 'html']);
      gulp.watch('./styles/**/*.scss', ['sass']);
  });

})();
