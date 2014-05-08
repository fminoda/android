package br.eti.minoda.rotinapedagogica;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RotinaPedagogicaPagerActivity extends Activity {
    
	private ViewPager rotinaPedagogicaPager;
	private static int NUM_ROTINA_VIEWS = 7;
	private Context cxt;
	private RotinaPedagogicaPagerAdapter rotinaPedagogicaAdapter;
	private int paginaInicial;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        cxt = this;
        
        rotinaPedagogicaAdapter = new RotinaPedagogicaPagerAdapter();
        rotinaPedagogicaPager = (ViewPager) findViewById(R.id.rotinapedagogicapager);
        rotinaPedagogicaPager.setAdapter(rotinaPedagogicaAdapter);
    	
       	/*
    	 * Se faz necessario subtrair porque o Calendar retorna o dia da semana iniciando por 
    	 * Domingo igual a 1 (um) e o PageAdapter inicia a contagem a partir de 0 (zero).
    	 */
        paginaInicial = (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1);
 
        rotinaPedagogicaPager.setCurrentItem(paginaInicial);
    }
    
    private StringBuffer retornaMateriaDoDia(int dia) {
	    StringBuffer sb = new StringBuffer();
   	
    	DaoAtividade daoAtividade = new DaoAtividade();
        sb.append(daoAtividade.getRotinaDiaria(dia));
        return sb;
    }
    
    private StringBuffer retornaDescricaoDiaSemana(int dia) {
	    StringBuffer sb = new StringBuffer();
        String quebraLinha = System.getProperty("line.separator");
        sb.append(DiaSemana.getDescricaoDiaSemana(dia) + quebraLinha + quebraLinha);
        return sb;
    }
    
    private class RotinaPedagogicaPagerAdapter extends PagerAdapter{

		
		@Override
		public int getCount() {
			return NUM_ROTINA_VIEWS;
		}

	    /**
	     * Create the page for the given position.  The adapter is responsible
	     * for adding the view to the container given here, although it only
	     * must ensure this is done by the time it returns from
	     * {@link #finishUpdate(android.view.ViewGroup)}.
	     *
	     * @param collection The containing View in which the page will be shown.
	     * @param position The page position to be instantiated.
	     * @return Returns an Object representing the new page.  This does not
	     * need to be a View, but can be some other container of the page.
	     */
		@Override
		public Object instantiateItem(ViewGroup collection, int position) {

			TextView tv = new TextView(cxt);
			
			String lf = System.getProperty("line.separator");			
			
			StringBuffer sb = new StringBuffer();
			sb.append(getString(R.string.app_message) + lf + lf);
			sb.append(getString(R.string.app_ano) + " " + getString(R.string.app_turno) + lf + lf);
			
			sb.append(retornaDescricaoDiaSemana(position + 1));
			
	       	/*
	    	 * Nao e necessario subtrair porque o array que armazena as materias inicia a contagem 
	    	 * a partir de 0 (zero).
	    	 */
			sb.append(retornaMateriaDoDia(position).toString() + lf);
			
			tv.setText(sb.toString());
			tv.setGravity(Gravity.CENTER);
			
			tv.setTextColor(Color.WHITE);
			tv.setTextSize(30);
					
			collection.addView(tv,0);
			
			return tv;

		}

	    /**
	     * Remove a page for the given position.  The adapter is responsible
	     * for removing the view from its container, although it only must ensure
	     * this is done by the time it returns from {@link #finishUpdate(android.view.ViewGroup)}.
	     *
	     * @param collection The containing View from which the page will be removed.
	     * @param position The page position to be removed.
	     * @param view The same object that was returned by
	     * {@link #instantiateItem(android.view.View, int)}.
	     */
		@Override
		public void destroyItem(ViewGroup collection, int position, Object view) {
			collection.removeView((TextView) view);
		}


        /**
         * Determines whether a page View is associated with a specific key object
         * as returned by instantiateItem(ViewGroup, int). This method is required
         * for a PagerAdapter to function properly.
         * @param view Page View to check for association with object
         * @param object Object to check for association with view
         * @return
         */
		@Override
		public boolean isViewFromObject(View view, Object object) {
			return (view==object);
		}

		
	    /**
	     * Called when the a change in the shown pages has been completed.  At this
	     * point you must ensure that all of the pages have actually been added or
	     * removed from the container as appropriate.
	     * @param arg0 The containing View which is displaying this adapter's
	     * page views.
	     */
		@Override
		public void finishUpdate(ViewGroup arg0) {}
		

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(ViewGroup arg0) {}
    	
    }
    
    
}