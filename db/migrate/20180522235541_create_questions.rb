class CreateQuestions < ActiveRecord::Migration[5.2]
  def change
    create_table :questions do |t|
      t.string :title
      t.string :description
      t.string :category
      t.text   :keywords
      t.text   :votings
      t.timestamps
    end
  end
end
