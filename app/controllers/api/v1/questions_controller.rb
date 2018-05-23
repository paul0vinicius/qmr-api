module Api
	module V1
		class QuestionsController < ApplicationController

			# Listar todas as perguntas
			def index
				questions = Question.order('created_at DESC');
				render json: {status: 'SUCCESS', message:'Perguntas carregadas', data:questions}, status: :ok
			end

      # Listar pergunta passando o id
      def show
        question = Question.find(params[:id])
        render json: {status: 'SUCCESS', message: 'Pergunta carregada', data: question}, status: :ok
      end

      # Criar nova pergunta passando os parâmetros
      def create
        question = Question.new(question_params)
        if question.save
          render json: {status: 'SUCCESS', message:'Pergunta salva', data:question},status: :ok
        else
          render json: {status: 'ERROR', message:'Pergunta não salva', data:question.erros},status: :unprocessable_entity
        end
      end

      # Parâmetros da pergunta: Titulo, descrição, categoria,
      # palavras-chave (array) e votações relacionadas (array) (não implementado ainda)
      private
      def question_params
        params.permit(:title, :description, :category, :keywords => [], :votings => [])
      end

		end
	end
end
