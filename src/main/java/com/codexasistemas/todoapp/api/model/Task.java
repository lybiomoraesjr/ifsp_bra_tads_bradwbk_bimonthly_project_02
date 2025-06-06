package com.codexasistemas.todoapp.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "task")
@Getter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean done = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "task_tag", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public void markAsDone() {
        if (this.done)
            throw new IllegalStateException("A tarefa já está concluída.");
        this.done = true;
    }

    public void markAsUndone() {
        if (!this.done)
            throw new IllegalStateException("A tarefa já está pendente.");
        this.done = false;
    }

    public void toggleStatus() {
        this.done = !this.done;
    }

    public void updateTitle(String newTitle) {
        if (newTitle == null || newTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode estar vazio.");
        }
        this.title = newTitle.trim();
    }

    public void updateDescription(String newDescription) {
        this.description = (newDescription != null) ? newDescription.trim() : null;
    }

    public void assignUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        this.user = user;
    }

    public void changeCategory(Category newCategory) {
        if (newCategory == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula.");
        }
        this.category = newCategory;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public boolean isOwnedBy(User user) {
        return this.user != null && this.user.equals(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Task))
            return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}