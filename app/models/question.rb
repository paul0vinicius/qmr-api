class Question < ApplicationRecord
  serialize :votings, Array
  serialize :keywords, Array
end
