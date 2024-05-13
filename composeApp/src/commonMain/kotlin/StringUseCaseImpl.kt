class StringUseCaseImpl(
    private val stringRepository: StringRepository
) {
    operator fun invoke(): String {
        return stringRepository.dummyText().lowercase()
    }
}