package ru.beleychev.notes.client.common;

import ru.beleychev.notes.shared.dto.NoteDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for List actions
 * @author beleychev.ilya 10.08.2017   17:01
 */
public class SelectionModel {
	private List<NoteDTO> selectedItems = new ArrayList<>();

	public List<NoteDTO> getSelectedItems() {
		return selectedItems;
	}

	public void addSelection(NoteDTO noteDTO) {
		selectedItems.add(noteDTO);
	}

	public void removeSelection(NoteDTO noteDTO) {
		selectedItems.remove(noteDTO);
	}

	public boolean isSelected(NoteDTO noteDTO) {
		return selectedItems.contains(noteDTO);
	}
}
