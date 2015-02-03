package com.jacksai.cinema.service

import com.jacksai.cinema.model.Category
import com.jacksai.cinema.repository.CategoryRepository
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class CategoryServiceTest extends Specification {

    def categoryRepository = Mock(CategoryRepository)
    def categoryService = new CategoryService(categoryRepository);

    def "should save and return categories from repository"() {

        given:
            def category = new Category();

        when:
            categoryService.save(category)

        then:
            1 * categoryRepository.save(_)

    }

    def "should delete category from repository"() {

        given:
            def category = new Category()

        when:
            categoryService.delete(category)

        then:
            1 * categoryRepository.delete(category.id)
    }

    def "should get all categories from repository"() {

        when:
            categoryService.findAll();

        then:
            1 * categoryRepository.findAll()
    }

    def "should find specific category by id"() {

        when:
            categoryService.findOne(1)

        then:
            1 * categoryRepository.findOne(1)
    }

}
