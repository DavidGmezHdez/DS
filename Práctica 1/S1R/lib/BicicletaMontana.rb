require('./Ruby/Bicicleta.rb');

module Ruby
	public
	class BicicletaMontana < Bicicleta

		public
		def clonar()
			return self
		end

		public
		def initialize()
      super()
		end
	end
end
