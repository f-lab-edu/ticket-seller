package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements JpaRepository {
    private final EntityManager em;

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteAllInBatch(Iterable entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Object getOne(Object o) {
        return null;
    }

    @Override
    public Object getById(Object o) {
        return null;
    }

    @Override
    public Object getReferenceById(Object o) {
        return null;
    }

    @Override
    public List findAll(Example example, Sort sort) {
        return null;
    }

    @Override
    public List findAll(Example example) {
        return null;
    }

    @Override
    public List saveAllAndFlush(Iterable entities) {
        return null;
    }

    @Override
    public Object saveAndFlush(Object entity) {
        return null;
    }

    @Override
    public List saveAll(Iterable entities) {
        return null;
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public List findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void deleteAllById(Iterable iterable) {

    }

    @Override
    public void deleteAll(Iterable entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List findAll(Sort sort) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional findOne(Example example) {
        return Optional.empty();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public Page findAll(Example example, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Example example) {
        return 0;
    }

    @Override
    public boolean exists(Example example) {
        return false;
    }

    @Override
    public Object findBy(Example example, Function queryFunction) {
        return null;
    }
}
