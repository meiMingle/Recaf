package me.coley.recaf.ui.control;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

/**
 * ComboBox for enumeration types.
 *
 * @param <E>
 * 		Enumeration type.
 *
 * @author Matt
 */
public class EnumComboBox<E extends Enum<?>> extends ComboBox<E> {
	/**
	 * @param type
	 * 		Enumeration type.
	 * @param initial
	 * 		Initial selection.
	 */
	public EnumComboBox(Class<E> type, E initial) {
		super(FXCollections.observableArrayList(type.getEnumConstants()));
		setValue(initial);
	}
}