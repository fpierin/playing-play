package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Task extends Model {

	private static final long serialVersionUID = -7161351873652106184L;

	@Id
	public Long id;

	@Required
	public String label;

	public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);

	public static List<Task> all() {
		return find.all();
	}

	public static void create(final Task task) {
		task.save();
	}

	public static void delete(final Long id) {
		find.ref(id).delete();
	}

}
