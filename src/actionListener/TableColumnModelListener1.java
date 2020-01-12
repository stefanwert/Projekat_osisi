package actionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

import dialog.DialogSpisakStudenataNaPredmetu;
import dialog.DialogStudent;
import pogled.MainFrame;


public class TableColumnModelListener1 implements TableColumnModelListener{

	@Override
	public void columnAdded(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnMarginChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnMoved(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnRemoved(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnSelectionChanged(ListSelectionEvent e) {
		System.out.println(e.getFirstIndex()+"  "+e.getLastIndex());
		if(e.getLastIndex()==5){
			System.out.println("asdasdas");
			//DialogStudent.getInstance().call(MainFrame.getInstance(),"Dodaj studenta",true);
			//ovde palis dijalog
		}
	}

}
