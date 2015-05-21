(function(){

  'use strict';
  var gulp = require('gulp'),
      jshint = require('gulp-jshint'),
      sass = require('gulp-sass');


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

  //configure files for watching
  gulp.task('watch', function() {
      gulp.watch(['**/*.js','!./node_modules/**','!./libs/**'], ['jshint']);
      gulp.watch('./styles/**/*.scss', ['sass']);
  });

})();
