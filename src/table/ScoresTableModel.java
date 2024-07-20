package table;

import model.Scores;

import javax.swing.table.AbstractTableModel;

// The model of the table component which contains the score
public class ScoresTableModel extends AbstractTableModel {
    private Scores scores;
    private String[] columnNames = {"Math 20-1 Date", "Math 20-1 Score", "Physics 20 Date", "Physics 20 Score", "CS 20 Date", "CS 20 Score"};
    private Class[] columnClass = {String.class, String.class, String.class, String.class, String.class, String.class};

    public ScoresTableModel(Scores scores) {
        this.scores = scores;
    }

    @Override
    public int getRowCount() {
        return scores.maxSubjectResultCount(new String[]{"Math 20-1", "Physics 20", "CS 20"});
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return scores.getSubjectResult("Math 20-1", rowIndex).getDate();
        } else if (columnIndex == 1) {
            return scores.getSubjectResult("Math 20-1", rowIndex).getScore();
        } else if (columnIndex == 2) {
            return scores.getSubjectResult("Physics 20", rowIndex).getDate();
        } else if (columnIndex == 3) {
            return scores.getSubjectResult("Physics 20", rowIndex).getScore();
        } else if (columnIndex == 4) {
            return scores.getSubjectResult("CS 20", rowIndex).getDate();
        } else if (columnIndex == 5) {
            return scores.getSubjectResult("CS 20", rowIndex).getScore();
        }
        return null;
    }
}
