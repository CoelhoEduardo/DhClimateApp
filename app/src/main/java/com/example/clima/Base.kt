/*
class ProfileScreen : AppCompatActivity() {

    private val viewModel: ProfileViewModel by viewModels()
    private val loading: FrameLayout
        get() = findViewById(R.id.loading)
    private val phone: TextInputEditText
        get() = findViewById(R.id.phone)
    private val name: TextInputEditText
        get() = findViewById(R.id.name_input)
    private val bday: TextInputEditText
        get() = findViewById(R.id.birthday)
    private val location: TextInputEditText
        get() = findViewById(R.id.location)
    private val profilePicture: ImageView
        get() = findViewById(R.id.profilephoto)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        viewModel.loadProfile()
        observeData()
    }

    fun observeData() {
        viewModel.loading.observe(this) { loading.isVisible = it }
        viewModel.error.observe(this) {
            if (it)
                Toast.makeText(this, "Deu Erro", Toast.LENGTH_LONG).show()
        }
        viewModel.profile.observe(this) {
            phone.setText(it.phone)
            name.setText(it.name.first)
            bday.setText(it.registered.date)
            location.setText(it.location.city)
            profilePicture.load(it.picture.thumbnail)
        }
    }
} */
