module Api
	module V1
		class QuestionsController < ApplicationController

			# Listar todas as perguntas
			def index
				questions = Question.order('created_at DESC');
				render json: {status: 'SUCCESS', message:'Perguntas carregadas', data:questions}, status: :ok
			end

		end
	end
end
