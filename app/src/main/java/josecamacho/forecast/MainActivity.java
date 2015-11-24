package josecamacho.forecast;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceHolderFragment())
                    .commit();
        }
    }

    public static class PlaceHolderFragment  extends Fragment {

        public PlaceHolderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

    // Cree algunos datos ficticios para el ListView . Aquí está un pronóstico semanal muestra

            String[]  data = {
                    "Mon 6/23 - Sunny - 31/17",
                    "Tue 6/24 - Foggy - 21/8",
                    "Wed 6/25 - Cloudy - 22/17",
                     "Thurs 6/26 - Rainy - 18/11",
                    "Fri 6/27 - Foggy - 21/10",
                    "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                    "Sun 6/29 - Sunny - 20/7"
            };
            List<String> weekForecast = new ArrayList<>(Arrays.asList(data));


            // Ahora que tenemos algunos datos de previsión ficticias , crear una ArrayAdapter .
            // El ArrayAdapter tomará datos de una fuente (como nuestro pronóstico ficticio) y
            // Utilizarla para rellenar el ListView está conectada.


            ArrayAdapter<String> forecastAdapter =
                    new ArrayAdapter<>(
                            getActivity(), // El contexto actual ( esta actividad ) .
                            R.layout.list_item_forecast, // El nombre del ID de diseño
                            R.id.list_item_forecast_textview,// El ID del TextView para poblar
                            weekForecast);



            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Obtener una referencia al ListView , y adjuntar este adaptador a la misma.

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(forecastAdapter);




            return rootView;
        }
    }
}
