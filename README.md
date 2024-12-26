# Android Demo Aplikacija z HoloGraphLibrary

Ta projekt uporablja **HoloGraphLibrary** knjižnico za prikaz grafov v Android aplikaciji.

## Zakaj HoloGraphLibrary?
HoloGraphLibrary je odprtokodna knjižnica za prikazovanje grafov in vizualizacij v Android aplikacijah. Omogoča enostavno integracijo barvno privlačnih grafov, kot so črtni grafi, tortni grafi in stolpčni grafi, kar je uporabno pri vizualizaciji podatkov v aplikacijah.

## Prednosti:
- **Enostavna uporaba:** Knjižnica je zasnovana z namenom hitre in enostavne integracije.
- **Vizualna privlačnost:** Grafi sledijo načelom oblikovanja "Holo" teme, ki je bila priljubljena v zgodnjih verzijah Androida.
- **Dokumentacija:** Osnovna dokumentacija in primeri so na voljo v repozitoriju.
- **Odprtokodna:** Brezplačna za uporabo in prilagajanje.

## Slabosti:
- **Zastarelost:** Zadnja posodobitev knjižnice je iz leta 2017, kar pomeni, da je podpora za novejše Android funkcionalnosti lahko omejena.
- **Pomanjkanje aktivnega vzdrževanja:** Knjižnica nima aktivne skupnosti ali razvijalcev.
- **Omejen nabor funkcij:** V primerjavi z bolj sodobnimi knjižnicami (npr. Vico) ima manj funkcionalnosti.

## Število uporabnikov in vzdrževanje:
- Knjižnica ima več kot 500 zvezdic na GitHubu, kar kaže na priljubljenost v preteklosti.
- Zadnji prispevek v repozitorij je bil narejen leta 30.10.2017.
- 15 vprašanj oz. težav v repozitoriju je neodgovorjenih.
- Avtorji niso aktivni, podpora za nove Android SDK-je ni zagotovljena.
- Ima 184 "forkov" na GitHubu, kar kaže na zanimanje skupnosti za nadaljnji razvoj.
- V času razvoja je sodelovalo 14 razvijalcev.
- Ima 7 neodgovorjenih "pull requestov".

## Licenca:
Knjižnica je objavljena pod licenco **Apache License 2.0**, kar omogoča prosto uporabo, spreminjanje in distribucijo.

## Primeri uporabe:

### Pitni graf: 

Vizualizira deleže različnih kategorij v celoti.

![Pie Graph Screenshot](images/pie_graph.png)

```kotlin
val slices = listOf(
    PieSlice().apply {
        setColor(Color.parseColor("#FF5722"))
        setValue(30f)
        setTitle("Slice 1")
    },
    PieSlice().apply {
        setColor(Color.parseColor("#4CAF50"))
        setValue(20f)
        setTitle("Slice 2")
    },
    PieSlice().apply {
        setColor(Color.parseColor("#2196F3"))
        setValue(25f)
        setTitle("Slice 3")
    },
    PieSlice().apply {
        setColor(Color.parseColor("#FFC107"))
        setValue(15f)
        setTitle("Slice 4")
    },
    PieSlice().apply {
        setColor(Color.parseColor("#9C27B0"))
        setValue(10f)
        setTitle("Slice 5")
    }
)
```

### Črtni graf: 

Prikazuje spremembe vrednosti skozi čas.
 
![Line Graph Screenshot](images/line_graph.png)

```kotlin
val line = Line().apply {
    addPoint(LinePoint().apply {
        setX(0f)
        setY(5f)
    })
    addPoint(LinePoint().apply {
        setX(8f)
        setY(8f)
    })
    addPoint(LinePoint().apply {
        setX(10f)
        setY(4f)
    })
    setColor(Color.parseColor("#FFBB33"))
}

lineGraph.addLine(line)
lineGraph.setRangeY(0f, 10f)
lineGraph.setLineToFill(0)
```

### Stolpčni graf: 

Primerja vrednosti med različnimi kategorijami.

![Bar Graph Screenshot](images/bar_graph.png)

```kotlin
val points = ArrayList<Bar>()
val bar1 = Bar().apply {
    color = Color.parseColor("#99CC00")
    name = "Test1"
    value = 10f
}
val bar2 = Bar().apply {
    color = Color.parseColor("#FFBB33")
    name = "Test2"
    value = 20f
}
points.add(bar1)
points.add(bar2)

barGraph.bars = points
```

### MainActivity:

![Main Activity Screenshot](images/main.png)

```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLineGraph.setOnClickListener {
            findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.lineGraphFragment)
        }

        binding.btnBarGraph.setOnClickListener {
            findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.barGraphFragment)
        }

        binding.btnPieGraph.setOnClickListener {
            findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.pieGraphFragment)
        }
    }
}
```

## Projektna implementacija:

V projektu je uporabljena **HoloGraphLibrary** za prikaz grafa, ki prikazujeje porabo denarja v različnih kategorijah.

![Project Screenshot](images/expenses.png)